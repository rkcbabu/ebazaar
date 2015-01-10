/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.pm.ebazaar.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import mum.pm.ebazaar.service.DownloadService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author sunil
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @Resource(name = "downloadService")
    private DownloadService downloadService;

    @RequestMapping(value = "/vendor/{type}/pdf", method = RequestMethod.GET)
    public void getPDF(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, JRException {
        downloadService.downloadPDF(request, response);
    }

    @RequestMapping(value = "/vendor/{type}/xls", method = RequestMethod.GET)
    public void getXLS(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, JRException {
        downloadService.downloadXLS(request, response);
    }

    @RequestMapping(value = "/vendor/{type}/html", method = RequestMethod.GET)
    public void getHtml(@PathVariable("type") String type, HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, JRException {
        downloadService.downloadHTML(request, response);
    }
}
