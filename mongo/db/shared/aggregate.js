db.import_demo.aggregate([
    {
        $addFields: {
            message: 'hello-world'
        }
    },
    {
        $out: "aggregate_demo"
    }
]);
