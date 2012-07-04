/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desdegdl.util;

import java.net.*;
import java.io.*;
import java.nio.charset.Charset;

public class URLReader {

    private URL _url;
    private String _charset;

    public URLReader(String url) throws MalformedURLException {
        this._url = new URL(url);
    }

    public URLReader(String url, String charset) throws MalformedURLException {
        this._url = new URL(url);
        this._charset = charset;
    }

    public StringBuilder read() throws IOException {
        StringBuilder sb = new StringBuilder(Math.round((float) (64669 * 1.2)));
        BufferedReader in = null;

        try {
            if (_charset != null) {
                in = new BufferedReader(
                        new InputStreamReader(
                        _url.openStream(), Charset.forName(this._charset)));
            } else {
                in = new BufferedReader(
                        new InputStreamReader(
                        _url.openStream()));
            }

            String inputLine;
            String lb = System.getProperty("line.separator");

            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine).append(lb);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignoreThis) { }
            }
        }

        return sb;
    }
}
