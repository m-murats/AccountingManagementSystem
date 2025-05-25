/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import java.io.File;
import java.util.List;

public interface ReportExporter<T> {
    void export(List<T> data, File file);
}