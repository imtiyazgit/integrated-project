package groovy.com.accion.labs.test1

import com.accion.labs.test1.XmlOperations

/**
 * Created by imtiyaz on 7/5/17.
 */
class XmlOperationsSpec extends spock.lang.Specification {
    def xmlOperations = new XmlOperations()

    def "Test reading xml nodes"() {
        given:
        String file = "src/main/resources/test1.xml"

        when:
        xmlOperations.readXmlNodes(file)

        then:
        xmlOperations.readXmlNodes(file).getLength() > 0
    }

    def "Test print denominations"() {
        expect:
        xmlOperations.printItemInfo(item, amount) == result

        where:
        item     | amount || result
        "Coffee"  | "5c" || "Coffee 5c"
        "Green Tea" | "34\$" || "Green Tea 20\$10\$2\$2\$"
        "Mocha" | "45\$" || "Mocha 20\$20\$5\$"
    }

}
