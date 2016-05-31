/**
 * Created by SG0222221 on 11/13/2015.
 */
class GroovyTest {
    public static void main(String[] args) {

        // Example 1
        def classes = [String, List, File]
        for (clazz in classes) {
            println clazz.package.name
        }

        println([String, List, File].'package'.name)

        // Example 2
        def customers = new XmlSlurper().parse(new File('C:\\ALearning\\IntegratedProject\\groovy\\input\\customer.xml'))
        for (customer in customers.corporate.customer) {
            println "${customer.@name} works for ${customer.@company}"
        }


    }
}
