//14 line || java || 1 ms || 99% faster || Optimized solution
public boolean isValid(String s) {
	Stack < Character > stack = new Stack < Character > ();
	for (Character c: s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
}