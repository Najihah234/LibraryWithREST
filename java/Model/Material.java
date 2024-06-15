package Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="material")
public class Material {
	
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name="materialid")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int materialid;
	
	
	@Column(name="isbn")
	int isbn;
	
	@Column(name="title")
	String title;
	
	@Column(name="author")
	String author;
	
	@Column(name="publisher")
	String publisher;
	
	@Column(name="version")
	String version;
	
	@Column(name="description")
	String description;
	
	@Column(name="materialLink")
	String materialLink;
	
	@Column(name="type")
	String type;
	
	

	public Material(int materialid, int isbn, String title, String author, String publisher, String version,
			String description, String materialLink,String type) {
		super();
		this.materialid = materialid;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.version = version;
		this.description = description;
		this.materialLink = materialLink;
		this.type = type;
	}

	
	public int getMaterialid() {
		return materialid;
	}

	public void setMaterialid(int materialid) {
		this.materialid = materialid;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn2) {
		this.isbn = isbn2;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getMaterialLink() {
		return materialLink;
	}

	public void setMaterialLink(String materialLink) {
		this.materialLink = materialLink;
	}


	@Override
	public String toString() {
		return "Material [materialid=" + materialid + ", isbn=" + isbn + ", title=" + title + ", author=" + author
				+ ", publisher=" + publisher + ", version=" + version + ", description=" + description
				+ ", materialLink=" + materialLink + ", type=" + type + "]";
	}


	
	
	

	

}

