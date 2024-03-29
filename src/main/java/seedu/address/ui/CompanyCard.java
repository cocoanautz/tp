package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.company.Company;
import seedu.address.model.company.Date;
import seedu.address.model.company.Phone;
import seedu.address.model.tag.Tag;

/**
 * An UI component that displays information of a {@code Company}.
 */
public class CompanyCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Company company;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;

    @FXML
    private Label email;
    @FXML
    private FlowPane tags;

    @FXML
    private Label period;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public CompanyCard(Company company, int displayedIndex) {
        super(FXML);
        this.company = company;
        id.setText(displayedIndex + ". ");
        name.setText(company.getName().fullName);
        setPhone();
        setPeriod();
        email.setText(company.getEmail().value);
        company.getTags().stream()
                .sorted(Comparator.comparing(Tag::getTagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.capitalise())));
    }

    public void setPhone() {
        if (company.getPhone().value.equals(Phone.DEFAULT_NUMBER)) {
            phone.setText("No phone number");
        } else {
            phone.setText(company.getPhone().value);
        }
    }

    public void setPeriod() {
        if (company.getStartDate().getDate().equals(Date.getDefaultDate())
                || company.getEndDate().getDate().equals(Date.getDefaultDate())) {
            period.setText("");
        } else {
            period.setText(company.getStartDate().toString() + " to " + company.getEndDate().toString());
        }
    }
}
