import javax.xml.XMLConstants;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XsdXmlValidator {
    public static void main(String[] args) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File f = new File("xsd-basic/src/main/resources/students.xsd");
            Schema xsdSchema = schemaFactory.newSchema(f);
            Validator validator = xsdSchema.newValidator();
            validator.validate(new StreamSource(new File("xsd-basic/src/main/resources/students.xml")));
            System.out.println("valid");
        }catch (Exception e) {
            System.out.println("Not valid");
            e.printStackTrace();
        }
    }
}
