package com.example.firstproject.employees.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "mitarbeiter")
public class Employees {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer mitarbeiterid;
        @Column
        private String name;
        @Column
        private String vorname;

        @Column
        private String hausnummer;
        @Column
        private Integer plz;
        @Column
        private String ort;
        @Column
        @Email(message = "Ungültige E-Mail-Adresse")
        private String email;
        @Column
        private String mobilnetz;
        @Column
        private String geschlecht;
        // Constructors, getters, and setters (including a no-arg constructor)

        public Employees() {
                // Default constructor required by JPA
        }

        // Getter and setter methods for your fields

        public Integer getMitarbeiterid() {
                return mitarbeiterid;
        }

        public void setMitarbeiterid(Integer mitarbeiterid) {
                this.mitarbeiterid = mitarbeiterid;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getVorname() {
                return vorname;
        }

        public void setVorname(String vorname) {
                this.vorname = vorname;
        }

        public String getHausnummer() {
                return hausnummer;
        }

        public void setHausnummer(String hausnummer) {
                this.hausnummer = hausnummer;
        }

        public Integer getPlz() {
                return plz;
        }

        public void setPlz(Integer plz) {
                this.plz = plz;
        }

        public String getOrt() {
                return ort;
        }

        public void setOrt(String ort) {
                this.ort = ort;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getMobilnetz() {
                return mobilnetz;
        }

        public void setMobilnetz(String mobilnetz) {
                this.mobilnetz = mobilnetz;
        }

        public String getGeschlecht() {
                return geschlecht;
        }

        public void setGeschlecht(String geschlecht) {
                this.geschlecht = geschlecht;
        }
}
