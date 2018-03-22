package sample.web.ui;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


import com.opencsv.CSVWriter;

public class AuditLogsTest {
    public static void main(String[] a) throws IOException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        String filepath = "./170239395";
        String code = "UTF-8";
        ArrayList<String> arrayList = new ArrayList<>();
        AuditLogsParser auditLogsParser = new AuditLogsParser(filepath, code);
        AuditLog auditLog = new AuditLog();
        CSVWriter csvWriter = null;
        for (PropertyDescriptor pd : Introspector.getBeanInfo(AuditLog.class).getPropertyDescriptors()) {
            if (!pd.getName().equals("class")) {
                System.out.print(pd.getName()+",");
            } else {
                Class<?> T = pd.getPropertyEditorClass();
                System.out.print(T.getName());
            }
        }
        for (PropertyDescriptor pd : Introspector.getBeanInfo(AuditLog.class).getPropertyDescriptors()) {
            //I don't want to get the "class" property
            if (!pd.getName().equals("class")) {
                Method readMethod = pd.getReadMethod();
                if (readMethod.invoke(auditLog) != null) {
                    System.out.print(readMethod.invoke(auditLog) + ",");
                } else {
                    System.out.print("null,");
                }
            }
        }
    }
}
