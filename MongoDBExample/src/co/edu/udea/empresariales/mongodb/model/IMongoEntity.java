package co.edu.udea.empresariales.mongodb.model;

import com.mongodb.DBObject;

public interface IMongoEntity {

	public DBObject entityToDBObject();
}