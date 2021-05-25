let { jsPDF } = require("jspdf");

let doc = new jsPDF();

exports.BatchPdfWriter = (callback) => {



    doc.setFontSize(15);
    doc.text("Batch report (" + callback.batchid + ")\n\n", 15, 30);
    doc.text("Date and time: " + callback.DateTime + "\n\n" +
        "Product type: " + ProductType + "\n\n" +
        "Total amount of product: " + TotalProduct + "\n\n" +
        "Acceptable amount of product: " + (TotalProduct - DefectiveProduct) + "\n\n" +
        "Defective amount of product: " + DefectiveProduct + "\n\n" +
        "Humidity over time: " + callback.HumOverTime + "\n\n" +
        "Temperature over time: " + (callback.TempOverTime / 1000).toFixed(0) + " sec" + "\n\n" +
        "Time Spent in States" + callback.StateTime(0) + "%" + "\n\n" +
        "Created by Group ST04" + "\n\n"
        , 15, 50);

    doc.save("../../../batchreport" + callback.BatchId + ".pdf");
}