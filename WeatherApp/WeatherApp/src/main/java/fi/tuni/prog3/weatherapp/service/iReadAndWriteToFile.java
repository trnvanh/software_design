package fi.tuni.prog3.weatherapp.service;

public interface iReadAndWriteToFile {
    public String readFromFile(String fileName) throws Exception;

    public boolean writeToFile(String fileName) throws Exception;
}
