<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/headerAdmin.jsp" %>
  <title>Embed API Demo</title>
<script>
(function(w,d,s,g,js,fs){
  g=w.gapi||(w.gapi={});g.analytics={q:[],ready:function(f){this.q.push(f);}};
  js=d.createElement(s);fs=d.getElementsByTagName(s)[0];
  js.src='https://apis.google.com/js/platform.js';
  fs.parentNode.insertBefore(js,fs);js.onload=function(){g.load('analytics');};
}(window,document,'script'));
</script>
<div class="ui grid centered">
<div id="view-selector-1-container"></div>
<div id="embed-api-auth-container"></div>
<div id="chart-1-container"></div>
<div id="chart-2-container"></div>
<div id="chart-3-container"></div>
<section id="timeline"></section>
</div>
<script>
gapi.analytics.ready(function() {

  /**
   * Authorize the user immediately if the user has already granted access.
   * If no access has been created, render an authorize button inside the
   * element with the ID "embed-api-auth-container".
   */
   gapi.analytics.auth.authorize({
    container: 'embed-api-auth-container',
    clientid: '1048068622103-udnmctl1b1p2p8g9tqtcaflcb3c7p1e7.apps.googleusercontent.com'
  });


  /**
   * Create a ViewSelector for the first view to be rendered inside of an
   * element with the id "view-selector-1-container".
   */
  var viewSelector1 = new gapi.analytics.ViewSelector({
    container: 'view-selector-1-container'
  });

  /**
   * Create a ViewSelector for the second view to be rendered inside of an
   * element with the id "view-selector-2-container".
   */

  // Render both view selectors to the page.
 /*  viewSelector1.execute(); */
  gapi.analytics.auth.on('success', function(response) {
	    viewSelector1.execute();
	  });
 

  /**
   * Create the first DataChart for top countries over the past 30 days.
   * It will be rendered inside an element with the id "chart-1-container".
   */
  var dataChart1 = new gapi.analytics.googleCharts.DataChart({
    query: {
      metrics: 'ga:sessions',
      dimensions: 'ga:country',
      'start-date': '30daysAgo',
      'end-date': 'today',
      'max-results': 6,
      sort: '-ga:sessions'
    },
    chart: {
      container: 'chart-1-container',
      type: 'GEO',
       options: {
    	 backgroundColor:'#99D6EE',
    	 region:'142',
    	 colorAxis:{minValue: 0,  colors: ['white', 'red']}
      }
    }
  });
  
  var dataChart2 = new gapi.analytics.googleCharts.DataChart({
	    query: {
	      metrics: 'ga:sessions',
	      dimensions: 'ga:browser',
	      'start-date': '30daysAgo',
	      'end-date': 'today',
	      'max-results': 6,
	      sort: '-ga:sessions'
	    },
	    chart: {
	      container: 'chart-2-container',
	      type: 'PIE',
	      options: {
	        width: '100%',
	        pieHole: 4/9
	      }
	    }
	  });
  
  var dataChart3 = new gapi.analytics.googleCharts.DataChart({
	    query: {
	      'start-date': '90daysAgo',
	      'end-date': 'today',
	      metrics: 'ga:pageviews,ga:uniquePageviews,ga:timeOnPage,ga:bounces,ga:entrances,ga:exits',
	      sort: '-ga:pageviews',
	      dimensions: 'ga:pagePath',
	      'max-results': 10
	    },
	    chart: {
	      container: 'chart-3-container',
	      type: 'PIE',
	      options: {
	        width: '100%',
	        pieHole: 0.4,
	      }
	    }
	  });

  
  
  
  
  var timeline = new gapi.analytics.googleCharts.DataChart({
	    reportType: 'ga',
	    query: {
	      'dimensions': 'ga:date',
	      'metrics': 'ga:sessions',
	      'start-date': '7daysAgo',
	      'end-date': 'today',
	    },
	    chart: {
	      type: 'LINE',
	      container: 'timeline'
	    }
	  });

  /**
   * Create the second DataChart for top countries over the past 30 days.
   * It will be rendered inside an element with the id "chart-2-container".
   */

  /**
   * Update the first dataChart when the first view selecter is changed.
   */
  viewSelector1.on('change', function(ids) {
    dataChart1.set({query: {ids: ids}}).execute();
    timeline.set({query: {ids: ids}}).execute();
    dataChart2.set({query: {ids: ids}}).execute();
    dataChart3.set({query: {ids: ids}}).execute();
  });


  /**
   * Update the second dataChart when the second view selecter is changed.
   */
/*   viewSelector2.on('change', function(ids) {
    dataChart2.set({query: {ids: ids}}).execute();
  }); */

});
</script>