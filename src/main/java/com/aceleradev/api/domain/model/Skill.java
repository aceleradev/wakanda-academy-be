package com.aceleradev.api.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60, unique = true)
	private String code;

	@Column(nullable = false, length = 120)
	private String name;

	@Lob
	private String description;

	private Integer tribeSequence;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tribe_id", referencedColumnName = "id")
	private Tribe tribe;

	@OneToMany(mappedBy = "skill")
	private List<Lesson> lessons;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tribe getTribe() {
		return tribe;
	}

	public void setTribe(Tribe tribe) {
		this.tribe = tribe;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Integer getTribeSequence() {
		return tribeSequence;
	}

	public void setTribeSequence(Integer tribeSequence) {
		this.tribeSequence = tribeSequence;
	}

	@Override
	public String toString() {
		return "Skill [code=" + code + ", name=" + name + ", tribeSequence=" + tribeSequence + ", tribe=" + tribe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tribe == null) ? 0 : tribe.hashCode());
		result = prime * result + ((tribeSequence == null) ? 0 : tribeSequence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tribe == null) {
			if (other.tribe != null)
				return false;
		} else if (!tribe.equals(other.tribe))
			return false;
		if (tribeSequence == null) {
			if (other.tribeSequence != null)
				return false;
		} else if (!tribeSequence.equals(other.tribeSequence))
			return false;
		return true;
	}
}
