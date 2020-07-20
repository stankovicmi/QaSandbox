import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        RemoveAllTestCases.class,
        CreateAllTestCases.class,
        EditAllTestCases.class,
        RemoveAllEditedTestCases.class

})

public class TestSuite {
}
