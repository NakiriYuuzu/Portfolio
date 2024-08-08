/* Storing user's device details in a variable*/
const details = navigator.userAgent

/* Creating a regular expression
containing some mobile devices keywords
to search it in details string*/
const regexp = /iphone|kindle|ipad|Safari|AppleWebKit/i

/* Using test() method to search regexp in details
it returns boolean value*/
const isAppleDevice = regexp.test(details)

if (isAppleDevice) {
    document.write('<div class="container"> <object class="internal" type="text/html" data="js/index.html" ></object> </div>')
} else {
    document.write('<div class="container"> <object class="internal" type="text/html" data="wasmJs/index.html" ></object> </div>')
}