(function propertiesbuilder(attr) {
    var props = {};
    props["user"] = attr[connectionHelper.attributeUsername];
    props["password"] = attr[connectionHelper.attributePassword];
props["logdir"] = "c:\\users\\Administrator";

    return props;
})
