public class InventoryCSVParser {

    /**
     * Parses a CSV line in the form "ProductName,SKU,Quantity".
     * Validates that exactly 3 fields are present.
     * Prints formatted record or "Invalid Record".
     */
    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
        }
    }

    public static void main(String[] args) {
        // Test cases from the problem
        System.out.println("Test 1:");
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        // Expected: Product: Wireless Mouse | SKU: WM-2201 | Qty: 150

        System.out.println("Test 2:");
        parseInventoryRecord("Wireless Mouse,150");
        // Expected: Invalid Record

        System.out.println("Test 3:");
        parseInventoryRecord("Keyboard,KB-1001,75,ExtraField");
        // Expected: Invalid Record
    }
}
