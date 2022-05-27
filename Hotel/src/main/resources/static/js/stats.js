$.ajax({
	url: 'orders/linechartdata',
	success: function(result) {
		var name = JSON.parse(result).name;
		var revenue = JSON.parse(result).revenue;
		drawLineChart(name, revenue)
	}
});
function drawLineChart(name, revenue) {
	Highcharts.chart('MyRoomChart', {
		chart: {
			type: 'column',
			width: 600,
			height: 400,
		},
		
		title: {
			text: 'Thống kê doanh thu theo phòng'
		},

		xAxis: {
			categories: name
		},

		tooltip: {
			formatter: function() {
				return '<strong>' + this.x + ': </strong>' + this.y;
			}
		},

		series: [{
			data: revenue
		}]
	});
}