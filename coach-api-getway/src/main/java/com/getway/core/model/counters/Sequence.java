package com.getway.core.model.counters;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "document_sequences")
public class Sequence {

	// Seqence name
	@Id     
	private String id;
	private long seq;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seqNo) {
		this.seq = seqNo;
	}
	
	
}
