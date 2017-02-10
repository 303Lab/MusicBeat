/**
 * Karma Test Runner
 * Created by windawings on 2017/1/31 0031.
 */

describe('A Suite', function() {
    it('Contains spec with an expectation', function () {
        console.log('This is msg from log...');
        expect(true).toBe(true);
    })
});

describe('A Suite of Basic Functions', function () {
    it('reverse word', function () {
        expect('DCBA').toEqual(('ABCD'));
        expect('4321').toEqual(myReverse('1234'));
    })
});