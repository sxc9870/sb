//package com.sxc.mongo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.bson.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.MongoDbFactory;
//
//import com.mongodb.Block;
//import com.mongodb.MongoClient;
//import com.mongodb.client.AggregateIterable;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//
//public class MongoFactoryBean {
//
//	private final MongoDbFactory mongo;
//	private MongoDatabase db;
//	private MongoCollection<Document> doc;
//	private MongoClient client;
//	@Autowired
//	public MongoFactoryBean(MongoDbFactory mongo) {
//		this.mongo = mongo;
//		db=mongo.getDb();
//	}
//
//	// ...
//
//	public void example() {
//		final List<Document> ret = new ArrayList<>();
//		for(int i=1;i<10;i++){
//			int j=i;
//		ret.add(new Document(){
//			{
//				append("name", "sxc"+j);
//				append("monmey",j*1000);
//			}
//		});
//		}
//		MongoDatabase db = mongo.getDb();
//		doc=	db.getCollection("sxc1");//insertMany(ret);
//		
//		doc.insertMany(ret);
//	}
//	
//	private Block<Document> getBlock(final List<Document> ret) {
//		Block<Document> printBlock = new Block<Document>() {
//			@Override
//			public void apply(Document t) {
////				logger.info(t.toJson());
//				Object object = t.get("comments");
//				System.out.println(object);
//				ret.add(t);
//			}
//		};
//		return printBlock;
//	}
//	private void printOperation(List<Document> ret, Block<Document> printBlock,
//			AggregateIterable<Document> aggregate) {
//		aggregate.forEach(printBlock);
//		System.out.println(ret.size());
//		ret.removeAll(ret);
//		
//	}
//}