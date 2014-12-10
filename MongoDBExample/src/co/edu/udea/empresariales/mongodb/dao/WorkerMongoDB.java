package co.edu.udea.empresariales.mongodb.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.empresariales.mongodb.model.Worker;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class WorkerMongoDB {

	private DB db;
	private MongoClient mongoClient;

	public WorkerMongoDB(String serverName, int serverPort, String databaseName) {
		this.mongoClient = null;

		try {
			this.mongoClient = new MongoClient(serverName, serverPort);
			this.db = this.mongoClient.getDB(databaseName);
		} catch (UnknownHostException ex) {
			System.err.println(ex);
		}
	}

	private DBCollection getCollection(String collectionName) {
		DBCollection dbCollection = this.db.getCollection(collectionName);
		if (dbCollection == null) {
			dbCollection = this.db.createCollection(collectionName, null);
		}

		return (dbCollection);
	}

	public List<Worker> findByFirstNames(String firstNames,
			String collectionName) {
		DBCollection dbCollection = this.getCollection(collectionName);
		BasicDBObject query = new BasicDBObject(Worker.FIRST_NAMES, firstNames);
		DBCursor dbCursor = dbCollection.find(query);
		List<Worker> workersList = new ArrayList<>();

		while (dbCursor.hasNext()) {
			workersList
					.add((Worker) Worker.entityFromDBObject(dbCursor.next()));
		}

		return (workersList);
	}

	public boolean save(Worker worker, String collectionName) {
		DBCollection dbCollection = this.getCollection(collectionName);
		WriteResult writeResult = dbCollection
				.insert(worker.entityToDBObject());

		return (writeResult.getField("ok").equals(Double.valueOf("1.0")));
	}

	public Worker update(Worker worker, String collectionName) {
		DBCollection dbCollection = this.getCollection(collectionName);
		BasicDBObject basicDBObject = new BasicDBObject(Worker.DOCUMENT_ID,
				worker.getDocumentId());
		BasicDBObject updaterBasicDBObject = new BasicDBObject("$set",
				worker.entityToDBObject());
		WriteResult writeResult = dbCollection.update(basicDBObject,
				updaterBasicDBObject, false, true);

		return ((writeResult.getN() != 0) ? worker : null);
	}

	public void close() {
		this.mongoClient.close();
	}
}