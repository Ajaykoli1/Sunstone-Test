
function isPalindrome(str) {
   
    const cleaned = str.replace(/\s+/g, '').toLowerCase();
    
    return cleaned === cleaned.split('').reverse().join('');
}

console.log(isPalindrome("Race car")); 
