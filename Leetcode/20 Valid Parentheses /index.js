/**
 * @param {string} s
 * @return {boolean}
 */
var isValid_one = function (s) {
    const stack = [];
    const parens = '() [] {}'
    let i = 0
    while (i < s.length) {
        stack.push(s[i]);
        i++;

        let open = stack[stack.length - 2];
        let closed = stack[stack.length - 1];

        let petParens = open + closed
        if (parens.includes(petParens)) {
            stack.pop()
            stack.pop()
        }

    }
    return stack.length === 0
};

var isValid_two = function (s) {
    const stack = [];
    const matchingParentheses = {
        ')': '(',
        ']': '[',
        '}': '{'
    };

    for (let i = 0; i < s.length; i++) {
        const char = s[i];

        // If it's an opening parenthesis, push it onto the stack
        if (char === '(' || char === '[' || char === '{') {
            stack.push(char);
        } else {
            // If it's a closing parenthesis, check for matching opening parenthesis
            if (stack.length === 0 || stack.pop() !== matchingParentheses[char]) {
                return false;
            }
        }
    }

    // If the stack is empty, all parentheses were matched correctly
    return stack.length === 0;
};

console.log(isValid_one('()')) // output true
console.log(isValid_one('()[]{}')) // output true
console.log(isValid_one('(){}][]}')) // output false
console.log(isValid_one('(]')) // output false
console.log(isValid_one('({])')) // output false

console.log(isValid_two('()')) // output true
console.log(isValid_two('()[]{}')) // output true
console.log(isValid_two('(){}][]}')) // output false
console.log(isValid_two('(]')) // output false
console.log(isValid_two('({])')) // output false