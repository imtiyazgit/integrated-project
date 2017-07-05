package groovy.com.accion.labs.test1

import com.accion.labs.test1.Denominations

/**
 * Created by imtiyaz on 7/5/17.
 */
class DenominationsSpec extends spock.lang.Specification {

    def "Test reading xml nodes"() {
        expect:
        Denominations.find(amtInCentsOnly) == result

        where:
        amtInCentsOnly || result
        Optional.of(5) || "5c"
        Optional.of("3400") || "20\$10\$2\$2\$"
        Optional.of("4500") || "20\$20\$5\$"

    }
}
