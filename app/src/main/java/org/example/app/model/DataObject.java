package org.example.app.model;

/**
 * Repräsentiert ein Daten-Punkt/ Zeile in einem Datensatz
 */
public interface DataObject {
    /**
     * Funktion zum Setzen der Objekt-Daten bzw. Zellenwerte
     * @param data Array von Zellenwerten
     * @throws Exception Bei nicht passender Anzahl an Zellenwerten
     */
    public void setData(String[] data) throws Exception;
}
