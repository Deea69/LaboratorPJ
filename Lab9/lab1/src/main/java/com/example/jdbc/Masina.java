package com.example.jdbc;

import org.springframework.stereotype.Component;

@Component
public class Masina {
	private String nr_inm;
	private String marca;
	private String culoare;
	private int anul_fab;
	private int nr_km;
	
	public Masina(String nr_int, String marca, String culoare, int anfab, int nrkm) {
		super();
		this.nr_inm = nr_int;
		this.marca = marca;
		this.culoare = culoare;
		this.anul_fab = anfab;
		this.nr_km = nrkm;
	}

	public Masina() {}

	public String getNr_inm() {
		return nr_inm;
	}

	public void setNr_inm(String nr_inm) {
		this.nr_inm = nr_inm;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCuloare() {
		return culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	public int getAnul_fab() {
		return anul_fab;
	}

	public void setAnul_fab(int anul_fab) {
		this.anul_fab = anul_fab;
	}

	public int getNr_km() {
		return nr_km;
	}

	public void setNr_km(int nr_km) {
		this.nr_km = nr_km;
	}

	@Override
	public String toString() {
		return "masina [nr_inm=" + nr_inm + ", marca=" + marca + ", culoare=" + culoare + ", anul_fab=" + anul_fab
				+ ", nr_km=" + nr_km + "]";
	}
	
	
	
}
