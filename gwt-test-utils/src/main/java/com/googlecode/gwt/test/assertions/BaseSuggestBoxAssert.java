package com.googlecode.gwt.test.assertions;

import static org.fest.util.Objects.areEqual;

import com.google.gwt.user.client.ui.SuggestBox;

/**
 * Base class for {@link SuggestBox} assertions.
 * 
 * @author Gael Lazzari
 * 
 * @param <S> used to simulate "self types." For more information please read &quot;<a href=
 *           "http://passion.forco.de/content/emulating-self-types-using-java-generics-simplify-fluent-api-implementation"
 *           target="_blank">Emulating 'self types' using Java Generics to simplify fluent API
 *           implementation</a>.&quot;
 * @param <A> the type of the "actual" value.
 */
public class BaseSuggestBoxAssert<S extends BaseSuggestBoxAssert<S, A>, A extends SuggestBox>
         extends BaseWidgetAssert<S, A> {

   /**
    * Creates a new <code>{@link BaseSuggestBoxAssert}</code>.
    * 
    * @param actual the actual value to verify.
    * @param selfType the "self type."
    */
   protected BaseSuggestBoxAssert(A actual, Class<S> selfType) {
      super(actual, selfType);
   }

   /**
    * Verifies that the actual {@link SuggestBox} is currently enabled.
    * 
    * @return this assertion object.
    * @throws AssertionError if the actual {@link SuggestBox} is not enabled.
    * 
    * @see SuggestBox#getTextBox()
    */
   public S isEnabled() {
      if (actual.getTextBox().isEnabled())
         return myself;

      throw failWithMessage("should be enabled");
   }

   /**
    * Verifies that the actual {@link SuggestBox} is not currently enabled.
    * 
    * @return this assertion object.
    * @throws AssertionError if the actual {@link SuggestBox} is enabled.
    * 
    * @see SuggestBox#getTextBox()
    */
   public S isNotEnabled() {
      if (!actual.getTextBox().isEnabled())
         return myself;

      throw failWithMessage("should not be enabled");
   }

   /**
    * Verifies that the actual {@link SuggestBox} limit is equal to the given one.
    * 
    * @param expected the given limit to compare the actual limit to.
    * @return this assertion object.
    * @throws AssertionError if the actual limit is not equal to the given one.
    * 
    * @see SuggestBox#getLimit()
    */
   public S limitEquals(int expected) {
      int limit = actual.getLimit();
      if (areEqual(limit, expected))
         return myself;
      throw propertyComparisonFailed("limit", limit, expected);
   }

   /**
    * Verifies that the actual {@link SuggestBox} value is equal to the given one.
    * 
    * @param expected the given value to compare the actual value to.
    * @return this assertion object.
    * @throws AssertionError if the actual value is not equal to the given one.
    * 
    * @see SuggestBox#getValue()
    */
   public S valueEquals(String expected) {
      String value = actual.getValue();
      if (areEqual(value, expected))
         return myself;
      throw propertyComparisonFailed("value", value, expected);
   }

}