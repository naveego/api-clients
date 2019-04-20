/*
This file fixes an autorest bug that is happening on the Auth swagger.  It is producing
a duplicate "contentType" property on some of the operation types.
*/

const replace = require('replace-in-file');

const options = {
    files: './lib/auth.ts',

    from: /contentType: "application\/x-www-form-urlencoded",[\s]*contentType: "application\/x-www-form-urlencoded",/g,
    to: 'contentType: "application/x-www-form-urlencoded",'
}

let changedFiles = replace.sync(options);
console.log('Modified files:', changedFiles.join(', '));
    