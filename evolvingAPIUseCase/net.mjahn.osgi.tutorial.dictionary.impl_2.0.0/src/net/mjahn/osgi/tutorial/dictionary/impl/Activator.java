package net.mjahn.osgi.tutorial.dictionary.impl;

import java.util.Hashtable;

import net.mjahn.osgi.tutorial.dictionary.Dictionary;
import net.mjahn.osgi.tutorial.dictionary.DictionaryService;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	static ServiceTracker dictionaryTracker;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		dictionaryTracker = new ServiceTracker(context,Dictionary.class.getName(),null);
		dictionaryTracker.open();
		Hashtable<String, String> props = new Hashtable<String, String>();
		context.registerService(Dictionary.class.getName(), new DictionaryDEDE(), props);
		context.registerService(Dictionary.class.getName(), new DictionaryENUS(), props);
		// register the service
		context.registerService(DictionaryService.class.getName(), new DictionaryServiceImpl(context), props);

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		// nothing to do... will be taken care of by the osgi fw.
	}

	static Object[] getDictionaries(){
		return dictionaryTracker.getServices();
	}
	
//	public void serviceChanged(ServiceEvent ev) {
//		ServiceReference sr = ev.getServiceReference();
//		switch(ev.getType()) {
//			case ServiceEvent.REGISTERED:
//			{
//				Dictionary dictionary = (Dictionary) fContext.getService(sr);
//				service.registerDictionary(dictionary);
//			}
//			break;
//			case ServiceEvent.UNREGISTERING:
//			{
//				Dictionary dictionary = (Dictionary) fContext.getService(sr);
//				service.unregisterDictionary(dictionary);
//			}
//			break;
//		}
//	}


}
