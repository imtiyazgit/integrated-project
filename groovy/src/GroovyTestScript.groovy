class Book {
    String title;
}
def groovyBook = new Book()
groovyBook.setTitle('GroovyTest')
assert groovyBook.getTitle() ==  'GroovyTest'

def gStringTest = "GStringReplaceHolderMustBeUsedInDoubleQoutes"
assert "$gStringTest is valid" == 'GStringReplaceHolderMustBeUsedInDoubleQoutes is valid'

// Numbers examples. All are objects by default
def x = 1
def y = 2
assert x+y == 3
assert x.plus(y) == 3
assert x instanceof Integer

// List example
def roman = ['', 'I', 'II']
roman[99] = ['III'] // You can set a value outside very easily
assert roman.size() == 100

// Map example
def http_codes = [
        100: 'CONTINUE',
        200: 'OK',
        400: 'BAD REQUEST',
        500: 'INTERNAL ERROR'
]
assert http_codes[400] == 'BAD REQUEST'

// Range example
def range = 1..10
assert range.contains(5)
assert range.contains(15) == false
assert range.size() == 10
assert range.from == 1
assert range.to == 10
assert range.reverse() == 10..1

// usage of up to.. you can remove for loop
def totalClinks  = 0
def partyPeople = 100
1.upto(100) { guestNumber ->
    clinksWithGuest = guestNumber-1
    assert clinksWithGuest instanceof Number
    totalClinks += clinksWithGuest
}
assert totalClinks == (partyPeople * (partyPeople-1))/2

