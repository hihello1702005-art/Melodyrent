import { motion } from 'framer-motion';
export default function PageShell({children}){ return <motion.div initial={{opacity:0,y:18}} animate={{opacity:1,y:0}} exit={{opacity:0,y:-18}} transition={{duration:.35}}>{children}</motion.div> }
