(function dsbuilder(attr) {
    var urlBuilder = "jdbc:kdbs://" + attr[connectionHelper.attributeServer] + ":" + attr[connectionHelper.attributePort];

    return [urlBuilder];
})
