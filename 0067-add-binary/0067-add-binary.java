class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop as long as there are characters to process or a carry remains
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // Convert char to int
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0'; // Convert char to int
            }

            sb.append(sum % 2); // The binary digit (0 or 1)
            carry = sum / 2;    // The carry for the next position
        }

        // The digits were added from right to left, so reverse the result
        return sb.reverse().toString();
    }
}
