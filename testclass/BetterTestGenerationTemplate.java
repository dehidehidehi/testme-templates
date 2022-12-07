#parse("TestMe macros.java")
#parse("BetterTestGenerationCommonMacros.java")
#set($hasMocks=$MockitoMockBuilder.hasMockable($TESTED_CLASS.fields))
#if($PACKAGE_NAME)
package ${PACKAGE_NAME};
#end

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
#if($hasMocks)
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
#end
#parse("File Header.java")
class ${CLASS_NAME} {
#renderMockedFields($TESTED_CLASS.fields)
#set($hasTestableInstanceMethod = "#hasTestableInstanceMethodIncludingGettersAndSetters($TESTED_CLASS.methods)")
#renderTestSubjectInit($TESTED_CLASS,$hasTestableInstanceMethod,$hasMocks)
#if($hasMocks)
    @BeforeEach
    void setUp() {
        MockitoAnnotations.${MockitoMockBuilder.initMocksMethod}(this);
    }
#end
#foreach($method in $TESTED_CLASS.methods)
#if ($TestSubjectUtils.shouldBeTested($method) || $method.isGetter() || $method.isSetter())
    @Test
    void #renderTestMethodName($method.name)(){
#if($MockitoMockBuilder.shouldStub($method,$TESTED_CLASS.fields))
#renderMockStubs($method,$TESTED_CLASS.fields)
#end
#renderMethodCall($method,$TESTED_CLASS.name)
#if($method.hasReturn())        Assertions.#renderJUnitAssert($method)#end
    }
#end
#end
}
