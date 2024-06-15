package Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import Model.Material;
import dbUtil.HibernateSF;
import DAO.MaterialDAO;

@RestController
@RequestMapping("/api/material")
public class RESTMaterialController {
	
	private SessionFactory sessionFactory = HibernateSF.getSessionFactory();
	
	@GetMapping("/hello")
    public String hello() {
        return "Hello, !";
    }

    @PostMapping("/adddBook")
    public String addBook(@RequestBody Material material) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            
            List<Material> uList = session.createQuery("from Material", Material.class).list();
            boolean exists = uList.stream().anyMatch(m -> m.getIsbn() == material.getIsbn());

            if (exists) {
                return "redirect:/materialAdmin";
            } else {
                session.save(material);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return "redirect:/materialAdmin";
        }

        return "redirect:/materialAdmin";
    }
	
	@PostMapping({"/{materialid}"})
	   public String updateBook(@PathVariable("materialid") int materialid, @ModelAttribute Material updatedMaterial) {
	      Material m = MaterialDAO.displayById(materialid);
	      if (m != null) {
	         m.setMaterialid(updatedMaterial.getMaterialid());
	         m.setIsbn(updatedMaterial.getIsbn());
	         m.setTitle(updatedMaterial.getTitle());
	         m.setAuthor(updatedMaterial.getAuthor());
	         m.setPublisher(updatedMaterial.getPublisher());
	         m.setVersion(updatedMaterial.getVersion());
	         m.setDescription(updatedMaterial.getDescription());
	         MaterialDAO.updateMaterial(updatedMaterial.getMaterialid(), updatedMaterial.getIsbn(), updatedMaterial.getTitle(), updatedMaterial.getAuthor(), updatedMaterial.getPublisher(), updatedMaterial.getVersion(), updatedMaterial.getDescription());
	      }

	      return "redirect:/materialAdmin";
	   }
	
	//delete
	@DeleteMapping("/{materialid}")
    public ResponseEntity<String> deleteMaterial(@PathVariable("materialid") int materialid) {
        try (Session session = sessionFactory.openSession()) {
            Material material = session.get(Material.class, materialid);

            if (material != null) {
                session.beginTransaction();
                session.delete(material);
                session.getTransaction().commit();
                return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/materialAdmin").build();
            } else {
                return new ResponseEntity<>("Material not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the material.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
