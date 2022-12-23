################## Macros #####################
## Override
#macro(renderTestMethodName $methodName)
$methodName#testMethodSuffix($methodName,"")
#end
##
#macro (hasTestableInstanceMethodIncludingGettersAndSetters $methods)
#foreach($method in $methods)
#shouldBeTestedIncludingGettersAndSetters($method))
#end
#end
##
#macro (shouldBeTestedIncludingGettersAndSetters $method)
#set ($shouldBe = $TestSubjectUtils.shouldBeTested($method) || $method.isGetter() || $method.isSetter())
$shouldBe
#end
##
