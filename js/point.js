class Point {
    constructor(x, y) {
        this.x = x
        this.y = y
    }
    toString() {
        return '(' + this.x + ',' + this.y + ')';
    }
    abs() {
        return Math.sqrt(this.x ** 2 + this.y ** 2, 2)
    }
    add(x, y) {
        return new Point(x.x + y.x, x.y + y.y)
    }
    equal(x, y) {
        return x.x === y.x && x.y === y.y
    }
}

var p = new Point(1, 2)
p.toString()
p.abs()
var _p = Point.prototype.add(p, p)
Point.prototype.equal(p, p)