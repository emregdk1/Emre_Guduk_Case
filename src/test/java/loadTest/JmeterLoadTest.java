package loadTest;

import org.apache.jmeter.assertions.ResponseAssertion;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.ListedHashTree;

public class JmeterLoadTest {


    public static void main(String[] args) throws Exception {

        String searchKeyword = "phone";
        String searchUrl = "https://www.n11.com/";

        String jmeterHome = System.getProperty("user.dir");
        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.loadJMeterProperties(jmeterHome + "/src/test/resources/Jmeter.properties");
        JMeterUtils.initLocale();

        StandardJMeterEngine jmeterEngine = new StandardJMeterEngine();

        ListedHashTree testPlanTree = new ListedHashTree();

        HTTPSamplerProxy searchSampler = new HTTPSamplerProxy();
        searchSampler.setDomain(searchUrl);
        searchSampler.setPath("/arama?q=" + searchKeyword);
        searchSampler.setMethod("GET");
        searchSampler.setName("Search Request");
        searchSampler.setProtocol("https");
        searchSampler.setPort(443);

        ResponseAssertion responseBodyAssertion = new ResponseAssertion();
        responseBodyAssertion.setName("Response Body Assertion");
        responseBodyAssertion.setProperty("Assertion.test_field", "Assertion.test_field_response_data");
        responseBodyAssertion.setToContainsType();
        responseBodyAssertion.addTestString(searchKeyword);
        searchSampler.addTestElement(responseBodyAssertion);

        ResponseAssertion responseCodeAssertion = new ResponseAssertion();
        responseCodeAssertion.setName("Response Code Assertion");
        responseCodeAssertion.setProperty("Assertion.test_field", "Assertion.test_field_response_code");
        responseCodeAssertion.addTestString("200");
        searchSampler.addTestElement(responseCodeAssertion);

        LoopController loopController = new LoopController();
        loopController.setLoops(1);
        loopController.addTestElement(searchSampler);
        loopController.setFirst(true);
        loopController.initialize();

        org.apache.jmeter.threads.ThreadGroup threadGroup = new org.apache.jmeter.threads.ThreadGroup();
        threadGroup.setName("Test Thread Group");
        threadGroup.setNumThreads(1);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(loopController);

        TestPlan testPlan = new TestPlan("N11 Search Load Test Plan");

        ListedHashTree threadGroupTree = new ListedHashTree(threadGroup);
        threadGroupTree.add(searchSampler);

        testPlanTree.add(testPlan);
        testPlanTree.add(threadGroup, threadGroupTree);

        ResultCollector resultCollector = new ResultCollector();
        resultCollector.setFilename("test-results.jtl");
        testPlanTree.add(resultCollector);

        jmeterEngine.configure(testPlanTree);
        jmeterEngine.run();

        System.out.println("Test Completed! Results saved to: test-results.jtl");
    }
}
