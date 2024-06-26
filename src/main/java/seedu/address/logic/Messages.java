package seedu.address.logic;

import static seedu.address.logic.parser.CliSyntax.PREFIX_CUSTOMER_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MENU;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORDER;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.order.Order;
import seedu.address.model.order.Product;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_INVALID_ORDER_DISPLAYED_INDEX = "The order index provided is invalid";
    public static final String MESSAGE_INVALID_PRODUCT_DISPLAYED_INDEX = "The product index provided is invalid";
    public static final String MESSAGE_INVALID_MENU_DISPLAYED_INDEX = "The menu index provided is invalid,"
            + " make sure there is an existing item on the menu";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_ORDERS_LISTED_OVERVIEW = "%1$d orders listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): ";

    public static final String MESSAGE_INVALID_PHONE_NUMBER = "Phone number provided not found";
    public static final String MESSAGE_INVALID_DATE = "Please specify a valid date.";

    public static final String MESSAGE_PHONE_NUMBER_NOT_FOUND = "Phone number provided not found";
    public static final String MESSAGE_ORDER_NOT_CREATED = "Please create an order before adding products.";
    public static final String MESSAGE_LARGE_QUANTITY = "Quantity specified is too large, please try again.";

    public static final String MESSAGE_ONLY_ONE_FIELD = "Only one field can be provided";

    public static final String MESSAGE_COEXISTING_CUSTOMER_AND_ORDER =
            "Customer ID and order ID cannot coexist here.";
    public static final String MESSAGE_CUSTOMER_HAS_ORDER = "Customer has active order and cannot be removed.";

    public static final String MESSAGE_SPECIFY_EDIT = "Please follow up with either "
            + PREFIX_CUSTOMER_ID + "INDEX (for customer index)"
            + " , "
            + PREFIX_ORDER + "INDEX (for order index)"
            + " or "
            + PREFIX_MENU + "INDEX (for menu index)"
            + " to edit either customers, orders or menu items respectively";

    public static final String MESSAGE_SPECIFY_DELETE = "Please follow up with either "
            + PREFIX_CUSTOMER_ID + "INDEX (for customer index)"
            + " or "
            + PREFIX_MENU + "INDEX (for menu index)"
            + " to delete either customers or menu items respectively";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone())
                .append("; Email: ")
                .append(person.getEmail())
                .append("; Address: ")
                .append(person.getAddress())
                .append("; Tags: ");
        person.getTags().forEach(builder::append);
        return builder.toString();
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Order order) {
        return order.toString();
    }

    public static String format(Product product) {
        return product.getName();
    }
}
