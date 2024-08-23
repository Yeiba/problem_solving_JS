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
        console.log(stack)
        let open = stack[stack.length - 2];
        let closed = stack[stack.length - 1];

        let petParens = open + closed
        console.log(petParens)
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
    console.log(`"init" "${stack}"`)
    for (let i = 0; i < s.length; i++) {
        const char = s[i];

        console.log(`"cur" "${stack}"`)
        // If it's an opening parenthesis, push it onto the stack
        if (char === '(' || char === '[' || char === '{') {
            stack.push(char);
            console.log(`"stack[char]" "${stack}"`)
        } else {
            // If it's a closing parenthesis, check for matching opening parenthesis
            let state = stack.length === 0 || stack[0] !== matchingParentheses[char] ? false : true
            console.log(`"current state" "${state}"`)
            if (stack.length === 0 || stack.pop() !== matchingParentheses[char]) {
                console.log(`"stockpop" "${stack}"`)
                return false;
            }
        }
        console.log(`"end of loop" "${stack}"`)
    }


    // If the stack is empty, all parentheses were matched correctly
    return stack.length === 0;
};

// console.log(isValid_one('()')) // output true
// console.log(isValid_one('()[]{}')) // output true
// console.log(isValid_one('(){}][]}')) // output false
// console.log(isValid_one('({[]})') // output true
// console.log(isValid_one('(]')) // output false
// console.log(isValid_one('({])')) // output false


// console.log(isValid_two('()')) // output true
// console.log(isValid_two('()[]{}')) // output true
// console.log(isValid_two('({[]})')) // output true
// console.log(isValid_two('(){}][]}')) // output false
// console.log(isValid_two('(]')) // output false
// console.log(isValid_two('({])')) // output false