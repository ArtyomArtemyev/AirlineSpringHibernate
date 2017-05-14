(function () {

    google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawChart);
    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['Company', 'Amount'],
            ['ARTAIRLINE',     78.09],
            ['Deutsche Lufthansa', 20.95],
            ['Air France-KLM',    0.93],
            ['United Continental Holdings', 0.03]
        ]);
        var options = {
            title: 'Market of airline company',
            is3D: true,
            pieResidueSliceLabel: 'Other companies'
        };
        var chart = new google.visualization.PieChart(document.getElementById('diagramPie'));
        chart.draw(data, options);
    }

    google.load("visualization", "1", {packages:["corechart"]});
    google.setOnLoadCallback(drawChart2);
    function drawChart2() {
        var data2 = google.visualization.arrayToDataTable([
            ['Year', 'ARTAIRLINE'],
            ['2012', 450],
            ['2015', 800],
            ['2017', 1200]
        ]);
        var options2 = {
            title: 'Amount of choice customer our company',
            hAxis: {title: 'Year'},
            vAxis: {title: 'Amount choices'}
        };
        var chart2 = new google.visualization.ColumnChart(document.getElementById('oil'));
        chart2.draw(data2, options2);
    }


})();