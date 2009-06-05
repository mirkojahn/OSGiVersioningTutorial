package net.mjahn.osgi.tutorial.dictionary.client;

import java.util.Hashtable;

import net.mjahn.osgi.tutorial.dictionary.DictionaryService;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator, CommandProvider{

	private ServiceTracker dictServTracker;
	private BundleContext ctx;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		ctx = context;
		dictServTracker = new ServiceTracker(context,DictionaryService.class.getName(),null);
		dictServTracker.open();
		Hashtable<String,String> properties = new Hashtable<String, String>();
		properties.put("dict.console.version", "2.0.0");
		properties.put("dict.console.vendor", "mjahn.net");
		context.registerService(CommandProvider.class.getName(), this, properties);

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		dictServTracker.close();
		dictServTracker = null;
		ctx = null;
	}
	

	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\tdc20 - short for dictionary check consults installed dictionary and checks if the given work is known or not.\n");
		buffer.append("\t\t dc20 <word to check> <language> <check lemma>\n");
		buffer.append("\t\t sample: dc20 birds en_US true\n");
		return buffer.toString();
	}
	
	public void _dc20(CommandInterpreter ci) throws Exception {
		String word = ci.nextArgument();
		
//		// debugging stuff #start
//		boolean debug = false;
//		if("-d".equalsIgnoreCase(word)){
//			// debug enabled
//			debug = true;
//			word = ci.nextArgument();
//		}
//		// debugging stuff #end
		
		String lang = ci.nextArgument();
		
		ServiceReference[] srefs = dictServTracker.getServiceReferences();
		if(srefs != null && srefs.length > 0){
			for (int i=0;srefs.length>i;i++){
				DictionaryService serv = (DictionaryService)ctx.getService(srefs[i]);
				if(serv.check(word, lang)){
					ci.println("OK");
					return;
				}
			}
		}
		ci.println("[WARN] Word NOT found in dictionaries.");
	}

}
