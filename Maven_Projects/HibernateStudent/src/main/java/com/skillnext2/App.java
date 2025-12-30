package com.skillnext2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
            
            Session session = sessionFactory.openSession();
            List<Student> students = session.createQuery("FROM Student", Student.class).list();
            session.close();
            sessionFactory.close();
            
            // Generate HTML file
            generateHTML(students);
            
            System.out.println("HTML file generated: student_report.html");
            System.out.println("Open it in your browser!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void generateHTML(List<Student> students) throws IOException {
        FileWriter writer = new FileWriter("student_report.html");
        
        writer.write("<!DOCTYPE html>\n");
        writer.write("<html>\n");
        writer.write("<head>\n");
        writer.write("    <title>Student Report</title>\n");
        writer.write("    <style>\n");
        writer.write("        body { font-family: Arial, sans-serif; margin: 40px; }\n");
        writer.write("        h1 { color: #333; }\n");
        writer.write("        table { border-collapse: collapse; width: 100%; margin-top: 20px; }\n");
        writer.write("        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }\n");
        writer.write("        th { background-color: #4CAF50; color: white; }\n");
        writer.write("        tr:nth-child(even) { background-color: #f2f2f2; }\n");
        writer.write("        .count { background: #e7f3fe; padding: 10px; margin: 10px 0; }\n");
        writer.write("    </style>\n");
        writer.write("</head>\n");
        writer.write("<body>\n");
        writer.write("    <h1>📚 Student Report</h1>\n");
        writer.write("    <div class=\"count\">Total Students: " + students.size() + "</div>\n");
        
        writer.write("    <table>\n");
        writer.write("        <tr>\n");
        writer.write("            <th>ID</th>\n");
        writer.write("            <th>Name</th>\n");
        writer.write("            <th>Email</th>\n");
        writer.write("            <th>Branch</th>\n");
        writer.write("        </tr>\n");
        
        for (Student student : students) {
            writer.write("        <tr>\n");
            writer.write("            <td>" + student.getId() + "</td>\n");
            writer.write("            <td>" + student.getName() + "</td>\n");
            writer.write("            <td>" + student.getEmail() + "</td>\n");
            writer.write("            <td>" + student.getBranch() + "</td>\n");
            writer.write("        </tr>\n");
        }
        
        writer.write("    </table>\n");
        writer.write("    <div style=\"margin-top: 20px; font-style: italic;\">");
        writer.write("        Generated on: " + new java.util.Date());
        writer.write("    </div>\n");
        writer.write("</body>\n");
        writer.write("</html>\n");
        
        writer.close();
    }
}