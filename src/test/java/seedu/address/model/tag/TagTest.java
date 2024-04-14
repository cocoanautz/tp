package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidTagName));
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));
    }

    @Test
    public void capitaliseTest() {
        Tag tag = new Tag("software engineer");
        assertTrue(tag.capitalise().equals("Software Engineer"));

        tag = new Tag("softWare EnginEEr");
        assertTrue(tag.capitalise().equals("Software Engineer"));

    }

    @Test
    public void equals() {
        Tag legalTag = new Tag("Software Engineer");
        assertTrue(legalTag.equals(legalTag));

        Tag nullTag = null;
        assertFalse(legalTag.equals(nullTag));


    }

}
