package co.edu.udea.empresariales.mongodb.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.edu.udea.empresariales.mongodb.model.Worker;

public class TestWorkerMongoDB {

	public static final String SERVER_NAME = "localhost";
	public static int SERVER_PORT = 27017;

	public static final String MONGO_DATABASE_NAME = "db-example";
	public static final String MONGO_COLLECTION_NAME = "workers";

	private Worker worker;
	private WorkerMongoDB mongoDB;

	@After()
	public void finalize() {
		this.mongoDB.close();
	}

	@Before()
	public void initialize() {
		this.worker = new Worker();
		this.worker.setDocumentId("1234567890");
		this.worker.setFirstNames("Neiber");
		this.worker.setLastNames("Padierna Pérez");
		this.worker.setDate(new Date());
		this.worker.setAge(123);

		this.mongoDB = new WorkerMongoDB(SERVER_NAME, SERVER_PORT,
				MONGO_DATABASE_NAME);
	}

	@Test()
	public void testSave() {
		assertTrue(this.mongoDB.save(this.worker, MONGO_COLLECTION_NAME));
	}

	@Test()
	public void testUpdate() {
		this.worker.setFirstNames("Neiber de Jesús");
		this.worker.setDate(new Date());
		this.worker.setAge(987);

		assertNotNull(this.mongoDB.update(this.worker, MONGO_COLLECTION_NAME));
	}

	@Test()
	public void testFindByFirstNames() {
		String fullNames = "Neiber de Jesús";

		assertFalse(this.mongoDB.findByFirstNames(fullNames,
				MONGO_COLLECTION_NAME).isEmpty());
	}
}