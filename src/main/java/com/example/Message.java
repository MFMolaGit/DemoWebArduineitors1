/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.example;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

/**
 * @author Rob Winch
 */
//@Entity
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1658147667286297761L;

	@Id
//	@GeneratedValue
	private String id;

	@NotBlank(message = "Message is required.")
//	@Column(nullable = false)
	private String text;

	@NotBlank(message = "Summary is required.")
//	@Column(nullable = false)
	private String summary;

//	@Column(nullable = true)
	private Calendar created = Calendar.getInstance();

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getCreated() {
		return this.created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}