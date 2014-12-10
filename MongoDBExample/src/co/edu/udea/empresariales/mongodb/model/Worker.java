package co.edu.udea.empresariales.mongodb.model;

import java.io.Serializable;
import java.util.Date;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Worker implements IMongoEntity, Serializable {

	private static final long serialVersionUID = 4608263375250874635L;

	public static final String DOCUMENT_ID = "documentId";
	public static final String FIRST_NAMES = "firstNames";
	public static final String LAST_NAMES = "lastNames";
	public static final String DATE = "date";
	public static final String AGE = "age";

	private String documentId;
	private String firstNames;
	private String lastNames;
	private Date date;
	private int age;

	public Worker() {
		this(null, null, null, null, -1);
	}

	public Worker(String documentId, String firstNames, String lastNames,
			Date date, int age) {
		this.documentId = documentId;
		this.firstNames = firstNames;
		this.lastNames = lastNames;
		this.date = date;
		this.age = age;
	}

	public String getDocumentId() {

		return (this.documentId);
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getFirstNames() {

		return (this.firstNames);
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getLastNames() {

		return (this.lastNames);
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public Date getDate() {

		return (this.date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAge() {

		return (this.age);
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static IMongoEntity entityFromDBObject(DBObject dbObject) {
		Worker person = new Worker();

		person.setDocumentId((String) dbObject.get(DOCUMENT_ID));
		person.setFirstNames((String) dbObject.get(FIRST_NAMES));
		person.setLastNames((String) dbObject.get(LAST_NAMES));
		person.setDate((Date) dbObject.get(DATE));
		person.setAge((Integer) dbObject.get(AGE));

		return (person);
	}

	@Override()
	public DBObject entityToDBObject() {
		BasicDBObject basicDBObject = new BasicDBObject();

		basicDBObject.put(DOCUMENT_ID, this.getDocumentId());
		basicDBObject.put(FIRST_NAMES, this.getFirstNames());
		basicDBObject.put(LAST_NAMES, this.getLastNames());
		basicDBObject.put(DATE, this.getDate());
		basicDBObject.put(AGE, this.getAge());

		return (basicDBObject);
	}

	@Override()
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + this.getAge();
		result = prime * result
				+ ((this.getDate() == null) ? 0 : this.getDate().hashCode());
		result = prime
				* result
				+ ((this.getDocumentId() == null) ? 0 : this.getDocumentId()
						.hashCode());
		result = prime
				* result
				+ ((this.getFirstNames() == null) ? 0 : this.getFirstNames()
						.hashCode());
		result = prime
				* result
				+ ((this.getLastNames() == null) ? 0 : this.getLastNames()
						.hashCode());

		return (result);
	}

	@Override()
	public boolean equals(Object obj) {
		if (this == obj) {

			return (true);
		}

		if (obj == null) {

			return (false);
		}
		if (getClass() != obj.getClass()) {

			return (false);
		}

		Worker other = (Worker) obj;
		if (this.getAge() != other.getAge()) {

			return (false);
		}

		if (this.getDate() == null) {
			if (other.getDate() != null) {

				return (false);
			}
		} else {
			if (!this.getDate().equals(other.getDate())) {

				return (false);
			}
		}

		if (this.getDocumentId() == null) {
			if (other.getDocumentId() != null) {

				return (false);
			}
		} else {
			if (!this.getDocumentId().equals(other.getDocumentId())) {

				return (false);
			}
		}

		if (this.getFirstNames() == null) {
			if (other.getFirstNames() != null) {

				return (false);
			}
		} else {
			if (!this.getFirstNames().equals(other.getFirstNames())) {

				return (false);
			}
		}

		if (this.getLastNames() == null) {
			if (other.getLastNames() != null) {

				return (false);
			}
		} else {
			if (!this.getLastNames().equals(other.getLastNames())) {

				return (false);
			}
		}

		return (true);
	}

	@Override()
	public String toString() {

		return ("Person {\"documentId\":\"" + this.getDocumentId()
				+ "\", \"firstNames\":\"" + this.getFirstNames()
				+ "\", \"lastNames:\"" + this.getLastNames() + "\", \"date\":"
				+ this.getDate() + ", \"age\":" + this.getAge() + "}");
	}
}