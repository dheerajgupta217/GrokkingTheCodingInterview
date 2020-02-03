function biggestTable(grid) {
    const ifExists = (x, y, width, height) => {
        let exist = 1;
        for(let i = 0; i < width ; i++) {
            for(let j = 0; j < height ; j++) {
                exist &= grid[j + y] !== undefined && grid[j + y][i + x] == 1;
            }
        }
        return exist;
    };

    const largestTable = (x, y) => {
        let max = 0;
        for(let w = 1; w <= grid[0].length; w++) {
            for(let h = 1; h <= grid.length; h++) {
                const size = w * h;
                if (ifExists(x, y, width, height) && size>max) {
                    max = size;
                }
            }
        }
        return max;
    };

    let max = 0;
    for(let x = 0; x < grid[0].length; x++) {
        for(let y= 0; y < grid.length; y++) {
            const size = largestTable(x, y);
            if (size > max) {
                max = size;
            }
        }
    }
    return max;
}