### Goal

Instantly and automatically generate `JUnit5` test-class boilerplate and the usually mundane unit-tests in IntelliJ 
IDEA for a Java class.  
Automatically instantiate the class under test in a `setUp` method or in the field, using `Mockito` mocks if desired.


### Sample usage
1. Install the dependencies listed in the [requirements](#requirements) section.
1. Open the class you'd like to generate a test class for in IntelliJ idea.
1. `Right click`, select `Generate`, select `TestMe`, finally select the template you'd like to generate.
   1. or just do `ALT + SHIFT + Q`
   1. or customize the shortcut for this option in the IntelliJ `keymap settings`.

#### From this class you would generate...
```java
class SuperBigObject {

	private final String big;
	private final double theDouble;
	private final Short theShort;

	public SuperBigObject(final String big, final double thedouble, final Short theshort) {
		this.big = big;
		theDouble = thedouble;
		theShort = theshort;
	}

	public String getBig() {
		return big;
	}

	public double getTheDouble() {
		return theDouble;
	}

	public Short getTheShort() {
		return theShort;
	}
}

```

#### ... you would generate this test class!
```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SuperBigObjectTest {

    SuperBigObject superBigObject = new SuperBigObject("big", 0d, Short.valueOf((short) 0));

    @Test
    void testGetBig() {
        final String result = superBigObject.getBig();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetTheDouble() {
        final double result = superBigObject.getTheDouble();
        Assertions.assertEquals(0d, result);
    }

    @Test
    void testGetTheShort() {
        final Short result = superBigObject.getTheShort();
        Assertions.assertEquals(Short.valueOf((short) 0), result);
    }
}

```
### Current progress and further ideas

- [x] `getters`: assert the getter's returned value matches the associated field's value.
- [x] `setters`: assert the setter mutated the associated field's value.
- [ ] `constructors`: assert no constructors do throw an exception during instantiation.
- [ ] `private field modifiers`: assert all fields are private.
- [ ] `class visibility modifier`: for `non-public` classes, asserts the class's lower visibility modifier is 
  present.
- [ ] `method visibility modifiers`: for `non-public` methods, asserts each method's lower visibility modifier is
  present.
- [ ] `class annotations` : for annotated classes, assert each annotation is present.
- [ ] `class annotation parameters` : for each annotation on the class, for each parameter which has been set, 
  assert the annotation's parameter's value.
- [ ] `constructor annotations` : for annotated constructors, assert each annotation is present.
- [ ] `constructor annotation parameters` : for each annotation on the constructor, for each parameter which has been set,
  assert the annotation's parameter's value.
- [ ] `method annotations` : for annotated methods, assert each annotation is present.
- [ ] `method annotation parameters` : for each annotation on a method, for each parameter which has been set,
  assert the annotation's parameter's value.
- [ ] `field annotations` : for annotated fields, assert each annotation is present.
- [ ] `field annotation parameters` : for each annotation on a field, for each parameter which has been set,
  assert the annotation's parameter's value.

- [ ] `@Nested`

### Requirements
- `JUnit5`
- `Mockito`
- You must install the [TestMe IntelliJ Plugin](https://plugins.jetbrains.com/plugin/9471-testme). It is lightweight, 
  free, and open-source.

### How to use

1. Install the dependencies listed in the [requirements](#requirements).
1. Navigate to `src/main/java/velocity`
1. Import the `testclass`, `include`, or `macros` templates in `Settings > TestMe > TestMe Templates`.
1. Customize the behaviour of the template by using the settings available in IntelliJ: `Settings > TestMe`.
1. The plugin templates use the [Apache Velocity Engine](https://velocity.apache.org/) which is used for code-generation
   throughout IntelliJ IDEA.

### Additional ressources

If you'd like to further customize templates, the [**TestMe Javadoc**](https://weirddev.com/testme/javadoc/index.html)
are great for
getting started.

- [TestMe GitHub](https://github.com/wrdv/testme-idea)
- [TestMe Site](https://weirddev.com/testme/)
